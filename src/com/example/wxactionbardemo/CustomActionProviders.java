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

package com.example.wxactionbardemo;

import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView;

/**
 * This activity demonstrates how to use an {@link android.view.ActionProvider}
 * for adding functionality to the Action Bar. In particular this demo is adding
 * a menu item with ShareActionProvider as its action provider. The
 * ShareActionProvider is responsible for managing the UI for sharing actions.
 */
public class CustomActionProviders extends SherlockActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		((TextView) findViewById(R.id.text)).setText(R.string.text_content);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Create the search view
		SearchView searchView = new SearchView(getSupportActionBar()
				.getThemedContext());
		searchView.setQueryHint("Search");
		menu.add("Search")
				.setIcon(R.drawable.abs__ic_search)
				.setActionView(searchView)
				.setShowAsAction(
						MenuItem.SHOW_AS_ACTION_IF_ROOM
								| MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

		// Inflate your menu.
		getSupportMenuInflater().inflate(R.menu.custom_action_provider, menu);
		return true;
	}

}