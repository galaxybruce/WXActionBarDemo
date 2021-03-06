/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.wxactionbardemo.wedget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.actionbarsherlock.view.ActionProvider;
import com.example.wxactionbardemo.R;
import com.example.wxactionbardemo.bean.CustomChooser;
import com.example.wxactionbardemo.wedget.CustomChooserView.OnItemChooserListener;

/**
 * 
 * @author guilin
 * 
 */
public class CustomMoreActionProvider extends ActionProvider implements
		OnItemChooserListener {

	/**
	 * Context for accessing resources.
	 */
	private final Context mContext;

	private List<CustomChooser> list;

	/**
	 * Creates a new instance.
	 * 
	 * @param context
	 *            Context for accessing resources.
	 */
	public CustomMoreActionProvider(Context context) {
		super(context);
		mContext = context;

		list = new ArrayList<CustomChooser>();
		CustomChooser customChooser = new CustomChooser();
		customChooser.setIc_resource(R.drawable.ofm_add_icon);
		customChooser.setTitle("添加");
		list.add(customChooser);
		customChooser = new CustomChooser();
		customChooser.setIc_resource(R.drawable.ofm_card_icon);
		customChooser.setTitle("银行卡");
		list.add(customChooser);
		customChooser = new CustomChooser();
		customChooser.setIc_resource(R.drawable.ofm_collect_icon);
		customChooser.setTitle("我的收藏");
		customChooser.setOther("new");
		list.add(customChooser);
		customChooser = new CustomChooser();
		customChooser.setIc_resource(R.drawable.ofm_delete_icon);
		customChooser.setTitle("删除");
		list.add(customChooser);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public View onCreateActionView() {
		// Create the view and set its data model.
		CustomChooserView customChooserView = new CustomChooserView(mContext);
		customChooserView.setCustomChooserData(list);
		customChooserView.setOnItemChooserListener(this);
		// Lookup and set the expand action icon.
		customChooserView
				.setExpandActivityOverflowButtonResource(R.drawable.actionbar_more_icon);
		customChooserView.setProvider(this);

		// Set content description.
		customChooserView
				.setExpandActivityOverflowButtonContentDescription(R.string.description);

		return customChooserView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasSubMenu() {
		return true;
	}

	@Override
	public void onItemChooser(int position) {
		Toast.makeText(mContext, "choose item " + position, Toast.LENGTH_SHORT)
				.show();
	}
}
