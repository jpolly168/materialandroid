/*
 *  Copyright (C) 2016 Andrew Lord
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 */

package com.github.andrewlord1990.materialandroidsample.components.grids;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.github.andrewlord1990.materialandroidsample.BaseSampleActivity;
import com.github.andrewlord1990.materialandroidsample.R;

public class GridsSampleActivity extends BaseSampleActivity {

    public static final String EXTRA_GRID_TYPE = "extraGridType";

    private int gridType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gridType = getIntent().getIntExtra(EXTRA_GRID_TYPE, 0);

        setContentView(R.layout.activity_lists_sample);

        setupToolbar();
        setupList();
    }

    private void setupToolbar() {
        setTitle(R.string.sample_grids_title);
        showUpButton();
    }

    private void setupList() {
        RecyclerView list = (RecyclerView) findViewById(R.id.recyclerView);
        if (list != null) {
            int cellSize = getResources().getDimensionPixelSize(R.dimen.grid_cell_size);
            list.setLayoutManager(new GridAutoFitLayoutManager(this, cellSize));
            list.setHasFixedSize(true);
            list.setAdapter(new GridAdapter(this, gridType));
            int spacing = getResources().getDimensionPixelSize(R.dimen.md_grid_list_cell_spacing_small);
            list.addItemDecoration(new GridListSpacingItemDecoration(spacing));
        }
    }

}
