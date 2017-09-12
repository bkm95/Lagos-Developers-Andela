package bkm.com.ng.developers;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    public String a;
    private String x;
    protected String y;
    protected String z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String Recievedusername = getIntent().getStringExtra(MyAdapter.username);
        this.x =Recievedusername.toString();
        TextView un = (TextView) findViewById(R.id.profileUsername);
        un.setText(Recievedusername);

        String Recievedgiturl = getIntent().getStringExtra(MyAdapter.address);

        TextView gu = (TextView) findViewById(R.id.profileGiturl);
        gu.setText(Recievedgiturl);
        this.y = Recievedgiturl;

        String RecievedPicture = getIntent().getStringExtra(MyAdapter.profilePic);
        this.z = RecievedPicture.toString();
        ImageView Profile = (ImageView) findViewById(R.id.profilePic);
        Picasso.with(getApplicationContext())
                .load(RecievedPicture)
                .into(Profile);
        String info = "Check out this awesome developer @" + x + " <" + y + "> , <" + z + "> .";
        this.a = info;

    }

    public void gitToBrowser(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(y));
        startActivity(i);
    }

    public void shareProfile(View view){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_TEXT, a);
        i.setType("text/plain");
        startActivity(i);
    }

}