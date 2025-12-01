@MissionModel(model = Mission.class)
@WithMappers(BasicValueMappers.class)
@WithConfiguration(Configuration.class)
// @WithActivityType(ActivityType.class) // for new activity type
// @WithMetadata(name = "unit", annotation = gov.nasa.jpl.plandev.contrib.metadata.Unit.class) // for unit support
package missionmodel;

import gov.nasa.jpl.plandev.contrib.serialization.rulesets.BasicValueMappers;
import gov.nasa.jpl.plandev.merlin.framework.annotations.MissionModel;
import gov.nasa.jpl.plandev.merlin.framework.annotations.MissionModel.WithActivityType;
import gov.nasa.jpl.plandev.merlin.framework.annotations.MissionModel.WithConfiguration;
import gov.nasa.jpl.plandev.merlin.framework.annotations.MissionModel.WithMappers;
import gov.nasa.jpl.plandev.merlin.framework.annotations.MissionModel.WithMetadata;
