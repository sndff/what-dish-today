// Generated by view binder compiler. Do not edit!
package com.c22_067.whatdishtoday.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.c22_067.whatdishtoday.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SearchFilterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button10;

  @NonNull
  public final Button button11;

  @NonNull
  public final Button button4;

  @NonNull
  public final Button button5;

  @NonNull
  public final Button button7;

  @NonNull
  public final Button button8;

  @NonNull
  public final Button button9;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  private SearchFilterBinding(@NonNull ConstraintLayout rootView, @NonNull Button button10,
      @NonNull Button button11, @NonNull Button button4, @NonNull Button button5,
      @NonNull Button button7, @NonNull Button button8, @NonNull Button button9,
      @NonNull LinearLayout linearLayout, @NonNull TextView textView2,
      @NonNull TextView textView3) {
    this.rootView = rootView;
    this.button10 = button10;
    this.button11 = button11;
    this.button4 = button4;
    this.button5 = button5;
    this.button7 = button7;
    this.button8 = button8;
    this.button9 = button9;
    this.linearLayout = linearLayout;
    this.textView2 = textView2;
    this.textView3 = textView3;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SearchFilterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SearchFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.search_filter, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SearchFilterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button10;
      Button button10 = ViewBindings.findChildViewById(rootView, id);
      if (button10 == null) {
        break missingId;
      }

      id = R.id.button11;
      Button button11 = ViewBindings.findChildViewById(rootView, id);
      if (button11 == null) {
        break missingId;
      }

      id = R.id.button4;
      Button button4 = ViewBindings.findChildViewById(rootView, id);
      if (button4 == null) {
        break missingId;
      }

      id = R.id.button5;
      Button button5 = ViewBindings.findChildViewById(rootView, id);
      if (button5 == null) {
        break missingId;
      }

      id = R.id.button7;
      Button button7 = ViewBindings.findChildViewById(rootView, id);
      if (button7 == null) {
        break missingId;
      }

      id = R.id.button8;
      Button button8 = ViewBindings.findChildViewById(rootView, id);
      if (button8 == null) {
        break missingId;
      }

      id = R.id.button9;
      Button button9 = ViewBindings.findChildViewById(rootView, id);
      if (button9 == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      return new SearchFilterBinding((ConstraintLayout) rootView, button10, button11, button4,
          button5, button7, button8, button9, linearLayout, textView2, textView3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
