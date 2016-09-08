package org.openmrs.module.endtb.flowsheet.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FlowsheetConcept {

    private Set<String> singleConcepts;
    private Map<String, Set<String>> groupConcepts;

    public Set<String> getSingleConcepts() {
        if(null == this.singleConcepts) {
            this.singleConcepts = new LinkedHashSet<>();
        }
        return this.singleConcepts;
    }

    @JsonProperty("singleConcepts")
    public void setSingleConcepts(Set<String> singleConcepts) {
        this.singleConcepts = singleConcepts;
    }

    public Map<String, Set<String>> getGroupConcepts() {
        if(null == this.groupConcepts) {
            this.groupConcepts = new LinkedHashMap<>();
        }
        return this.groupConcepts;
    }

    @JsonProperty("groupConcepts")
    public void setGroupConcepts(Map<String, Set<String>> groupConcepts) {
        this.groupConcepts = groupConcepts;
    }
}
