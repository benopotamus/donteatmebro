package net.tinku.donteatmebro;

/**
 * Created by ben on 24/02/16.
 *
 * An interface to the native UI of various platforms.
 *
 * Each platforms implements the functions in this interface, using their platform specific ways.
 * Classes that implement this interface, include the code for launching the wizard, etc.
 */
public interface NativeUI {

    public static final int VIEW_TEST = 1;

    public void showShortToast(CharSequence toastMessage);
    public void showLongToast(CharSequence toastMessage);
    public void showAlertBox(String alertBoxTitle, String alertBoxMessage, String alertBoxButtonText);
    public void openUri(String uri);

    //public void showView(final int view);
    //public void hideView(final int view);

    public void showUI();
    public void hideUI();
}