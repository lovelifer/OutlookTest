package com.android.dev.outlooktest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by fangqiao on 16/7/16.
 */
public class AgendaFragment extends Fragment {

    private List<Agenda> agendaList = new ArrayList<Agenda>();
    private StickyListHeadersListView stickyListHeadersListView;
    private AgendaListAdapter agendaListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agenda, container, false);
        stickyListHeadersListView = (StickyListHeadersListView) view.findViewById(R.id.task_list);

        initData();

        agendaListAdapter = new AgendaListAdapter(getActivity(), agendaList);
        stickyListHeadersListView.setAdapter(agendaListAdapter);

        //stickyListHeadersListView.setOnItemClickListener(new OnPlanItemClick());

        return view;
    }

    private void initData() {

        for(int i=0;i<365;i++){
            Date date = new Date();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(calendar.DATE, i);
            Agenda agenda = new Agenda(calendar.getTime(),"No event","");
            agendaList.add(agenda);
        }


    }

    public void notifyList(Calendar calendar){
        Calendar currentCalendar = new GregorianCalendar();
        currentCalendar.setTime(new Date());
        long days= (calendar.getTimeInMillis()-currentCalendar.getTimeInMillis())/(1000*3600*24);
        this.stickyListHeadersListView.setSelection((int)days);

    }
}
