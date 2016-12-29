package sapotero.simplereader.application;

import android.app.Application;
import android.content.Context;

import sapotero.simplereader.application.components.DaggerMainComponent;
import sapotero.simplereader.application.components.MainComponent;
import sapotero.simplereader.application.modules.MainModule;
import timber.log.Timber;

public class SimpleApplication extends Application {
  private MainComponent mainComponent;

  @Override public void onCreate() {
    super.onCreate();
    Timber.plant(new Timber.DebugTree());

    mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
  }

  public MainComponent getComponent(Context context) {
    return ((SimpleApplication) context.getApplicationContext()).mainComponent;
  }
}
