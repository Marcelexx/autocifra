package marceloferracin.autocifra.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.layout.RoundedImageView;

/**
 *
 * Created by Marcelo Ferracin on 05/01/2016.
 */

public class ImageSelector {
    private Activity mActivity;
    private RoundedImageView mUserPhoto;
    private String mSelectedSource;

    public ImageSelector(Activity activity, RoundedImageView userPhoto) {
        mActivity = activity;
        mUserPhoto = userPhoto;
    }

    public void selectImage() {
        final CharSequence[] imageDialogItens = {
                mActivity.getString(R.string.profile_take_picture),
                mActivity.getString(R.string.profile_choose_picture),
                mActivity.getString(R.string.profile_picture_back)};

        AlertDialog.Builder imageSelectorDialog = new AlertDialog.Builder(mActivity);
        imageSelectorDialog.setTitle(mActivity.getString(R.string.profile_add_picture));
        imageSelectorDialog.setItems(imageDialogItens, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (imageDialogItens[item].equals(mActivity.getString(R.string.profile_take_picture))) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    mSelectedSource = "camera";
                    mActivity.startActivityForResult(intent, 0);
                } else if (imageDialogItens[item].equals(mActivity.getString(R.string.profile_choose_picture))) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    mSelectedSource = "file";
                    mActivity.startActivityForResult(
                            Intent.createChooser(intent, mActivity.getString(R.string.profile_picture_choose_file)),
                            0);
                } else if (imageDialogItens[item].equals(mActivity.getString(R.string.profile_picture_back))) {
                    dialog.dismiss();
                }
            }
        });

        imageSelectorDialog.show();
    }

    public String setProfileImage(int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (mSelectedSource.equals("camera")) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }

                try {
                    Bitmap bm;
                    BitmapFactory.Options btmapOptions = new BitmapFactory.Options();

                    bm = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            btmapOptions);

                    mUserPhoto.setImageBitmap(bm);

                    return f.getPath();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (mSelectedSource.equals("file")) {
                Uri selectedImageUri = data.getData();
                Bitmap bm = getImageBitmap(selectedImageUri, mActivity);
                mUserPhoto.setImageBitmap(bm);

                return getRealPathFromURI(selectedImageUri, mActivity);
            }
        }

        return null;
    }

    public String updateProfileImage(int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (mSelectedSource.equals("camera")) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }

                try {
                    return f.getPath();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (mSelectedSource.equals("file")) {
                Uri selectedImageUri = data.getData();
                return getRealPathFromURI(selectedImageUri, mActivity);
            }
        }

        return null;
    }

    public String convertImage(String path) {
        Bitmap bitmap = getImageFile(path);
        String result = "";
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 360, 360, true);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (resizedBitmap == null) {
            return result;
        } else {
            resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            result = Base64.encodeToString(byteArray, Base64.DEFAULT);
            return result;
        }
    }

    public Bitmap convertStringBase64ToBitmap(String base64Image) {
        if (base64Image != null) {
            byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);

            return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        }
        return null;
    }

    private String getRealPathFromURI(Uri contentURI, Activity activity) {
        String result;
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);

        if (cursor == null) {
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }

        return result;
    }

    private Bitmap getImageBitmap(Uri selectedImageUri, Activity activity) {
        String tempPath = getPath(selectedImageUri, activity);
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

        return BitmapFactory.decodeFile(tempPath, bitmapOptions);
    }

    private Bitmap getImageFile(String path) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

        return BitmapFactory.decodeFile(path, bitmapOptions);
    }

    private String getPath(Uri uri, Activity activity) {
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cursor = activity
                .managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();

        return cursor.getString(column_index);
    }
}