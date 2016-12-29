package sapotero.simplereader.application.components;


import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import sapotero.simplereader.application.modules.MainModule;
import sapotero.simplereader.view.activities.MainActivity;

@Singleton
@Component(modules = {
  MainModule.class
})

public interface MainComponent {
  void inject(MainActivity activity);

  Application application();
}