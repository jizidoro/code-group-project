package com.company.app.core.bases;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, LazyValidation.class})
public interface UseCaseValidationOrder {
}
