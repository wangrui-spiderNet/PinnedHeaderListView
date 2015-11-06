package za.co.immedia.pinnedheaderlistviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TestSectionedAdapter extends SectionedBaseAdapter {

    private ArrayList<String> objects;
    private ArrayList<String> sections;

    public TestSectionedAdapter(ArrayList<String> objects, ArrayList<String> sections) {
         this.objects=objects;
         this.sections=sections;
    }

    @Override
    public Object getItem(int section, int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int section, int position) {
        return position;
    }

    @Override
    public int getSectionCount() {
        return sections.size();
    }

    @Override
    public int getCountForSection(int section) {
        return objects.size();
    }

    @Override
    public View getItemView(int section, int position, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflator.inflate(R.layout.list_item, null);
        } else {
            layout = (LinearLayout) convertView;
        }

        ((TextView) layout.findViewById(R.id.textItem)).setText("Section " + sections.get(section) + " Item " + objects.get(position));

        return layout;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflator.inflate(R.layout.header_item, null);
        } else {
            layout = (LinearLayout) convertView;
        }

        ((TextView) layout.findViewById(R.id.textItem)).setText("Header for section " + sections.get(section));

        return layout;
    }

}
