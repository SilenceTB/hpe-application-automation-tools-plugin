/*
 *     Copyright 2017 Hewlett-Packard Development Company, L.P.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.hp.application.automation.tools.octane.actions.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kashbi on 25/09/2016.
 */
public class AutomatedTests {
    private ArrayList<AutomatedTest> data=new ArrayList<>();

    public List<AutomatedTest> getData() {
        return data;
    }

    public void setData(ArrayList<AutomatedTest> data) {
        this.data = data;
    }
}
