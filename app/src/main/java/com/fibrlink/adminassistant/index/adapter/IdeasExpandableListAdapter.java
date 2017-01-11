package com.fibrlink.adminassistant.index.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.fibrlink.adminassistant.R;
import com.fibrlink.adminassistant.global.tools.DataTools;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName AdminAssistant
 * @package name：com.fibrlink.adminassistant.index.adapter
 * @class describe
 * @anthor wolf
 * @time 2017/1/6 16:28
 * @change
 */
public class IdeasExpandableListAdapter extends BaseExpandableListAdapter {

    private Context mContext = null;

    public IdeasExpandableListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getGroupCount() {
        return DataTools.groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return DataTools.groupList.get(groupPosition).getUserlist().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return DataTools.groupList.get(groupPosition);
    }

    /*
	 * 设置子节点对象，在事件处理时返回的对象，可存放一些数据
	 */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return DataTools.groupList.get(groupPosition).getUserlist().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView text = null;
        if (convertView == null) {
            text = new TextView(mContext);
        } else {
            text = (TextView) convertView;
        }
        String name = (String) DataTools.groupList.get(groupPosition).getGroupname();
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 80);
        text.setLayoutParams(lp);
        text.setTextSize(18);
        text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        text.setPadding(56, 0, 0, 0);
        text.setText(name);
        text.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
        return text;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView text = null;
        if (convertView == null) {
            text = new TextView(mContext);
        } else {
            text = (TextView) convertView;
        }
        // 获取子节点要显示的名称
        String name = (String) DataTools.groupList.get(groupPosition).getUserlist().get(childPosition).getUsername();
        // 设置文本视图的相关属性
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 80);
        text.setLayoutParams(lp);
        text.setTextSize(18);
        text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        text.setPadding(56, 0, 0, 0);
        text.setText(name);

        text.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
        return text;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    /*
	 * 判断分组是否为空，本示例中数据是固定的，所以不会为空，我们返回false 如果数据来自数据库，网络时，可以把判断逻辑写到这个方法中，如果为空
	 * 时返回true
	 */
    public boolean isEmpty() {
        return false;
    }

    /*
     * 收缩列表时要处理的东西都放这儿
     */
    public void onGroupCollapsed(int groupPosition) {
    }

    /*
     * 展开列表时要处理的东西都放这儿
     */
    public void onGroupExpanded(int groupPosition) {
    }

    public boolean areAllItemsEnabled() {
        return false;
    }
}
