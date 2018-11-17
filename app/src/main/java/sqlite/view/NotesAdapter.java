package sqlite.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elvin.waitinglist.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import sqlite.database.model.Note;


public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private Context context;
    private List<Note> notesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView dot;
        public TextView timestamp;
        public TextView priority;
        public TextView course;
        public TextView studentId;
        public TextView note;



        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name1);
            dot = view.findViewById(R.id.dot);
            timestamp = view.findViewById(R.id.timestamp1);
            priority = view.findViewById(R.id.priority1);
            course = view.findViewById(R.id.course1);
            studentId=view.findViewById(R.id.studentID1);
            note=view.findViewById(R.id.note1);
        }
    }


    public NotesAdapter(Context context, List<Note> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = notesList.get(position);

        String PriorityName="None";
        switch(note.getPriority_num()){
            case 5:
                PriorityName="Freshmen";
                break;
            case 4:
                PriorityName="Sophomore";
                break;
            case 3:
                PriorityName="Junior";
                break;
            case 2:
                PriorityName="Senior";
                break;
            case 1:
                PriorityName="Graduate";
                break;
        }


        holder.name.setText("Name: "+note.getName());
        holder.studentId.setText("ID: "+note.getStudent_Id());
        holder.priority.setText("Priority: "+PriorityName);
        holder.course.setText("Course: "+note.getCourse_num());
        holder.note.setText("Notes: \n"+note.getNote());

        // Displaying dot from HTML character code
        holder.dot.setText(Html.fromHtml("&#8226;"));

        // Formatting and displaying timestamp
        holder.timestamp.setText(formatDate(note.getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2018-02-21 00:15:42
     * Output: Feb 21
     */
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }
}