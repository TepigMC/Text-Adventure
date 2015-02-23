package tepigmc.textadventure.action;

import java.util.ArrayList;
import java.util.List;

import tepigmc.textadventure.util.Array;

public class Option {
  private List<String> optionNames;
  private List<String> optionDescription;
  private Action optionAction;
  
  public Option(String[] names, String[] description, Action action) {
    this.optionNames = Array.toList(names);
    this.optionDescription = Array.toList(description);
    this.optionAction = action;
  }
  
  public Option(String name, String[] description, Action action) {
    setNames(name);
    this.optionDescription = Array.toList(description);
    this.optionAction = action;
  }
  
  public Option(String[] names, String description, Action action) {
    this.optionNames = Array.toList(names);
    setDescription(description);
    this.optionAction = action;
  }
  
  public Option(String name, String description, Action action) {
    setNames(name);
    setDescription(description);
    this.optionAction = action;
  }
  
  public List<String> getNames() { return this.optionNames; }
  public List<String> getDescription() { return this.optionDescription; }
  public Action getAction() { return this.optionAction; }
    
  public void setNames(List<String> names) { this.optionNames = names; }
  public void setNames(String name) {
    this.optionNames = new ArrayList<String>();
    this.optionNames.add(name);
  }
  public void setDescription(List<String> description) { this.optionDescription = description; }
  public void setDescription(String description) {
    this.optionDescription = new ArrayList<String>();
    this.optionDescription.add(description);
  }
  public void setAction(Action action) { this.optionAction = action; }
  
  public boolean isName(String name) {
    for (String optionName : this.optionNames) {
      if (optionName.equals(name)) { return true; }
    }
    return false;
  }
}