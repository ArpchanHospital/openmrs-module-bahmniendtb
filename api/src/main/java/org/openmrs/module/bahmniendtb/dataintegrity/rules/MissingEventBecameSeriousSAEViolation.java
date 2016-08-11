package org.openmrs.module.bahmniendtb.dataintegrity.rules;

import org.bahmni.module.dataintegrity.rule.RuleDefn;
import org.bahmni.module.dataintegrity.rule.RuleResult;
import org.openmrs.Concept;
import org.openmrs.PatientProgram;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.bahmniendtb.dataintegrity.rules.helper.MissingValuesHelper;

import java.util.Arrays;
import java.util.List;

import static org.openmrs.module.bahmniendtb.EndTBConstants.*;

public class MissingEventBecameSeriousSAEViolation implements RuleDefn<PatientProgram> {

    private ConceptService conceptService;

    private MissingValuesHelper missingValuesHelper;

    public MissingEventBecameSeriousSAEViolation(){
        conceptService = Context.getConceptService();
        missingValuesHelper = Context.getRegisteredComponent("missingValuesHelper",MissingValuesHelper.class);
    }

    public MissingEventBecameSeriousSAEViolation(MissingValuesHelper missingDatesHelper, ConceptService conceptService) {
        this.missingValuesHelper = missingDatesHelper;
        this.conceptService = conceptService;
    }

    @Override
    public List<RuleResult<PatientProgram>> evaluate() {

        Concept reportingDateQuestion = conceptService.getConceptByName(AE_REPORTING_DATE);
        Concept onsetDateQuestion = conceptService.getConceptByName(AE_ONSET_DATE);

        return missingValuesHelper
            .getInconsistenciesForMissingValues(AE_ADVERSE_EVENT_TEMPLATE, AE_ONSET_DATE,
                    Arrays.asList(reportingDateQuestion, onsetDateQuestion));
    }
}

