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

/**
 * User: Ali Ok (ali.ok@innflow.com)
 * Date: 2011-03-14
 * Time: 13:00:40
 */
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

public class OutputLabelEventListener implements SystemEventListener {

    protected final Log log = LogFactory.getLog(getClass());

    public boolean isListenerForSource(Object source) {
        return true;
    }

    public void processEvent(SystemEvent event) throws AbortProcessingException {
        HtmlOutputLabel outputLabel = (HtmlOutputLabel) event.getSource();
        if(StringUtils.isBlank(outputLabel.getFor()))
            log.warn("for attr is empty for outputLabel " + outputLabel.getClientId(FacesContext.getCurrentInstance()));

        UIComponent target = outputLabel.findComponent(outputLabel.getFor());
        if(target != null) {
            final Object labelVal = target.getAttributes().get("label");
            if(labelVal==null || ((labelVal instanceof String) && StringUtils.isNotBlank(labelVal.toString())))
                target.getAttributes().put("label", outputLabel.getValue());
        }
        else{
            log.warn("Target component with id " + outputLabel.getFor() + " cannot be found for output label component for id " + outputLabel.getClientId(FacesContext.getCurrentInstance()));
        }
    }
}