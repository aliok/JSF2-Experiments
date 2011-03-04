/*
 * Copyright [2011] [Ali Ok]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tr.com.aliok.jsf21experiments;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Ali Ok (ali.ok@innflow.com)
 * Date: 2011-02-24
 * Time: 14:08:29
 */
public class TestBean implements Serializable{

    public TestBean() {
        System.out.println("TestBean()");
    }

    public List<String> getFilledItems(){
        return Arrays.asList("item1", "item2");
    }

    public List<String> getEmptyItems(){
        return new ArrayList<String>();
    }

    public List<String> getNullItems(){
        return null;
    }
}
