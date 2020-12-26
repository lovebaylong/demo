package demo.validate;


import javax.validation.GroupSequence;

@GroupSequence({BaseInfo.class, AdvanceInfo.class})
public interface CompleteInfo {}
