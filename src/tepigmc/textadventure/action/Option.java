package tepigmc.textadventure.action;

import java.util.ArrayList;
import java.util.List;

import tepigmc.textadventure.util.Convert;

public class Option {
  private String optionName;
  private List<String> optionAliases;
  private List<String> optionDescription;
  private Action optionAction;
  
  public Option(String name, String[] aliases, String[] description, Action action) {
    this.optionName = name;
    this.optionAliases = Convert.arrayToList(aliases);
    this.optionDescription = Convert.arrayToList(description);
    this.optionAction = action;
  }
  
  public Option(String name, String[] description, Action action) {
    this.optionName = name;
    this.optionAliases = null;
    this.optionDescription = Convert.arrayToList(description);
    this.optionAction = action;
  }
  
  public Option(String name, String description, Action action) {
    this.optionName = name;
    this.optionAliases = null;
    this.optionDescription = new ArrayList<String>();
    this.optionDescription.add(description);
    this.optionAction = action;
  }
  
  public String getName() { return this.optionName; }
  public List<String> getAliases() { return this.optionAliases; }
  public List<String> getDescription() { return this.optionDescription; }
  public Action getAction() { return this.optionAction; }
}