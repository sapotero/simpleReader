package sapotero.simplereader.application.modules;

import android.content.Context;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.requery.Persistable;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.meta.EntityModel;
import io.requery.rx.RxSupport;
import io.requery.rx.SingleEntityStore;
import io.requery.sql.Configuration;
import io.requery.sql.ConfigurationBuilder;
import io.requery.sql.EntityDataStore;
import io.requery.sql.SchemaModifier;
import io.requery.sql.TableCreationMode;
import sapotero.simplereader.db.Models;

@Module
public final class DbModule {

  @Provides
  @Singleton
  SingleEntityStore<Persistable> provideDatabase(Context context) {
    DatabaseSource source = new DatabaseSource(context, Models.DEFAULT, 1);

    EntityModel model = Models.DEFAULT;
    Configuration configuration = new ConfigurationBuilder(source, model)
      .setStatementCacheSize(50)
      .setBatchUpdateSize(20)
      .setWriteExecutor(
        Executors.newSingleThreadExecutor()
      )
      .build();

    SchemaModifier schemaModifier = new SchemaModifier(configuration);


    schemaModifier.createTables(TableCreationMode.CREATE_NOT_EXISTS );

    return RxSupport.toReactiveStore( new EntityDataStore<Persistable>(configuration) );
  }
}