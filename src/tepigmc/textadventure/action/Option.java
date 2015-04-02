package tepigmc.textadventure.action;

import java.util.ArrayList;
import java.util.List;

import tepigmc.textadventure.util.Array;

public class Option {
  private List<String> optionNames;
  private List<String> optionDescription;
  private Action optionAction;
  
  public Option(List<String> names, List<String> description, Action action) {
    this.optionNames = names;
    this.optionDescription = description;
    this.optionAction = action;
  }
  
  public Option(String[] names, String[] description, Action action) {
    this(Array.toList(names), Array.toList(description), action);
  }
  
  public Option(String name, String[] description, Action action) {
    this(new ArrayList<String>(), Array.toList(description), action);
    this.optionNames.add(name);
  }
  
  public Option(String[] names, String description, Action action) {
    this(Array.toList(names), new ArrayList<String>(), action);
    this.optionDescription.add(description);
  }
  
  public Option(String name, String description, Action action) {
    this(new ArrayList<String>(), new ArrayList<String>(), action);
    this.optionNames.add(name);
    this.optionDescription.add(description);
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