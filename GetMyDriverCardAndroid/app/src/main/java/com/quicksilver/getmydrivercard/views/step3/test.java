//package com.quicksilver.getmydrivercard.views.step3;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.quicksilver.getmydrivercard.R;
//
//import java.io.ByteArrayOutputStream;
//
//import javax.inject.Inject;
//
//import butterknife.BindView;
//
//public class test {
//    package com.quicksilver.getmydrivercard.views.step3;
//
//
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.quicksilver.getmydrivercard.R;
//
//import java.io.ByteArrayOutputStream;
//
//import javax.inject.Inject;
//
//import butterknife.BindView;
//
//    /**
//     * A simple {@link Fragment} subclass.
//     */
//    public class CameraFragment extends Fragment implements Step3Contracts.View{
//
//        // Camera activity request code
//        private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
//        Button button;
//        ImageView imageView;
//
//        private Step3Contracts.Presenter mPresenter;
//        private Step3Contracts.Navigator mNavigator;
//
//        @BindView(R.id.txt_desc)
//        TextView mTextImage;
//
//        @BindView(R.id.img_preview)
//        ImageView mImagePreview;
//
//        @BindView(R.id.btn_capture_picture)
//        Button mButtonCamera;
//
//        @BindView(R.id.btn_upload_picture)
//        Button mButtonUpload;
//
//        @BindView(R.id.btn_next)
//        Button mButtonNext;
//
//        @Inject
//        public CameraFragment() {
//            // Required empty public constructor
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//
//            View view = inflater.inflate(R.layout.fragment_camera,
//                    container, false);
//
//            button = (Button) view.findViewById(R.id.btn_capture_picture);
//            imageView = (ImageView) view.findViewById(R.id.img_preview);
//
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(intent,
//                            CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
//
//                }
//            });
//
//            return view;
//
//        }
//
//        @Override
//        public void onActivityResult(int requestCode, int resultCode, Intent data) {
//            if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
//                if (resultCode == Activity.RESULT_OK) {
//
//                    Bitmap bmp = (Bitmap) data.getExtras().get("data");
//                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
//
//                    bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                    byte[] byteArray = stream.toByteArray();
//
//                    // convert byte array to Bitmap
//
//                    Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
//                            byteArray.length);
//
//                    imageView.setImageBitmap(bitmap);
//
//                }
//            }
//        }
//
//        @Override
//        public void setPresenter(Step3Contracts.Presenter presenter) {
//            mPresenter = presenter;
//        }
//
//        @Override
//        public void setNavigator(Step3Contracts.Navigator navigator) {
//            mNavigator = navigator;
//        }
//
//        @Override
//        public void onRestoreInstanceState(Bundle savedInstanceState) {
//
//        }
//    }
//
//}
