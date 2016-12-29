package sapotero.simplereader.db.utils;

public enum PostType {
  FAVORITES("favorites"),
  INTERESTING("interesting");


  private final String type;

  PostType(String type) {
    this.type = type;

  }

  public String getType() {
    return type;
  }
}
