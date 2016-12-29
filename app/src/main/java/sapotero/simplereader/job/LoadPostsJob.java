package sapotero.simplereader.job;

import android.support.annotation.NonNull;

import com.android.annotations.Nullable;
import com.birbit.android.jobqueue.CancelReason;
import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;


public class LoadPostsJob extends Job {
  private static final int PRIORITY = 1;
  private String text;

  public LoadPostsJob(String text) {
    super(new Params(PRIORITY).requireNetwork().persist());
  }

  @Override
  public void onAdded() {
  }

  @Override
  public void onRun() throws Throwable {

  }
  @Override
  protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
    return RetryConstraint.createExponentialBackoff(runCount, 1000);
  }
  @Override
  protected void onCancel(@CancelReason int cancelReason, @Nullable Throwable throwable) {

  }
}