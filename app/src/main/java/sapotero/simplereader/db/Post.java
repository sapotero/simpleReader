package sapotero.simplereader.db;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;

@Entity
public abstract class Post {

  @Key
  @Generated
  int id;

  String title;
  String link;
  String description;

  Integer type;


}
