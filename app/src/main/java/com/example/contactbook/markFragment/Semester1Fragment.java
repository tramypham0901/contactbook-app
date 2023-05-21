package com.example.contactbook.markFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.contactbook.R;
import com.example.contactbook.custom.CustomAdapter;
import com.example.contactbook.model.Mark;
import com.example.contactbook.model.SortMark;
import com.example.contactbook.remote.APIUtils;
import com.example.contactbook.service.MarkService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Semester1Fragment extends Fragment {

    List<Mark> marks = new ArrayList<>();
    List<SortMark> newMarks = new ArrayList<>();
    ListView listView;
    String userCode;
    private MarkService markService;

    public Semester1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contentView = inflater.inflate(R.layout.fragment_semester1, container, false);
        userCode = this.getArguments().getString("userCode");
        listView = contentView.findViewById(R.id.mark_list);
        markService = APIUtils.getMarkService();
        getMarkList();
        return contentView;
    }

    public void getMarkList() {
        Call<List<Mark>> call = markService.getMarksByStudent(userCode);
        call.enqueue(new Callback<List<Mark>>() {
            @Override
            public void onResponse(Call<List<Mark>> call, Response<List<Mark>> response) {
                if (response.isSuccessful()) {
                    marks = response.body();
                    newMarks = sortMarkList(marks);
                    listView.setAdapter(new CustomAdapter(getContext(), R.layout.custom_ds_adapter_diemso, newMarks));
                }
            }

            @Override
            public void onFailure(Call<List<Mark>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public List<SortMark> sortMarkList(List<Mark> markList) {
        markList.stream().sorted((o1, o2) -> {
            if (o1.getSubjectName().equalsIgnoreCase(o2.getSubjectName())) {
                return 1;
            }
            return 0;
        });
        List<SortMark> newList = new ArrayList<>();
        for (Mark m : markList) {
            if (m.getMarkType().equals("semester1")) {
                if (newList.size() == 0) {
                    SortMark sm = new SortMark();
                    sm.setSubjectName(m.getSubjectName());
                    sm = updateMark(sm, m.getMarkValue(), m.getFeedback());
                    newList.add(sm);
                } else {
                    SortMark filterMark = newList.stream().filter(el -> el.getSubjectName().equalsIgnoreCase(m.getSubjectName())).findFirst().get();
                    int index = newList.indexOf(filterMark);
                    if (filterMark != null) {
                        filterMark = updateMark(filterMark, m.getMarkValue(), m.getFeedback());
                        newList.set(index, filterMark);
                    } else {
                        SortMark sm = new SortMark();
                        sm.setSubjectName(m.getSubjectName());
                        sm = updateMark(sm, m.getMarkValue(), m.getFeedback());
                        newList.add(sm);
                    }
                }
            }
        }
        return newList;
    }

    public SortMark updateMark(SortMark sm, double value, String feedback) {
        sm.setMark1S("" + value);
        if (value < 5) {
            feedback = "Chưa hoàn thành";
        } else if (5 <= value && value <= 7) {
            feedback = "Hoàn thành";
        } else if (value > 7 && value < 9) {
            feedback = "Hoàn thành tốt";
        } else {
            feedback = "Hoàn thành xuất sắc";
        }
        sm.setFeedback(feedback);
        return sm;
    }
}