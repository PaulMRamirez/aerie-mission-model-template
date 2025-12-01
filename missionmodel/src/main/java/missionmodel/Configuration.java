package missionmodel;

import static gov.nasa.jpl.plandev.merlin.framework.annotations.Export.Template;

public record Configuration() {
  public static @Template Configuration defaultConfiguration() {
    return new Configuration();
  }
}
