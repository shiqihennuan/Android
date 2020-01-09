package cn.itcast.exo;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private ListView mListView;
    private String[] names={ "金珉硕", "鹿晗", "吴亦凡 ","金俊勉","张艺兴","边伯贤",
                             "金钟大", "朴灿烈", "都暻秀 ","黄子韬","金钟仁","吴世勋"};
    private int[]  icons= { R.drawable.xiumin,R.drawable.luhan,R.drawable.kris,R.drawable.suho, R.drawable.lay,
                            R.drawable.boxian,R.drawable.chen,R.drawable.can,R.drawable.dou, R.drawable.tao, R.drawable.kai, R.drawable.sehun};
    private String[] introduces = {
            "金珉硕，1990-03-26，大哥，童颜、领唱、副领舞",
            "鹿晗， 1990-04-20，主唱、领舞、门面",
            "吴亦凡，1990-11-06，队长、Leader、主Rapper、门面",
            "金俊勉，1991-05-22，队长、Leader、副唱",
            "张艺兴，1991-10-07，主领舞、副唱",
            "边伯贤， 1992-05-06，主唱、眼线",
            "金钟大，1992-09-21，主唱、猫系",
            "朴灿烈，1992-11-27，主Rapper、门面",
            "都暻秀，1993-1-12，主唱、演员",
            "黄子韬，1993-05-02，Rapper、武术表现",
            "金钟仁，1994-01-14，主领舞、Rapper、性感",
            "吴世勋，1994-04-12，领舞、门面"
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo);
        mListView = (ListView) findViewById(R.id.lv);
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        mListView.setAdapter(mAdapter);
    }
    class MyBaseAdapter extends BaseAdapter{
        @Override
        public int getCount(){
            return  names.length;
        }
        @Override
        public Object getItem(int position){
            return names[position];
        }
        @Override
        public long getItemId (int position){
            return position;
        }
        @Override
        public View getView(int position, View converView, ViewGroup parent){
            ViewHolder holder = null;
            if(converView == null){
                converView = View.inflate(MainActivity.this,R.layout.list_item,null);
                holder = new ViewHolder();
                holder.name = (TextView)converView.findViewById(R.id.name);
                holder.introduce = (TextView)converView.findViewById(R.id.introduce);
                holder.iv = (ImageView) converView.findViewById(R.id.iv);
                converView.setTag(holder);
            }else{
                holder = (ViewHolder) converView.getTag();
            }
            holder.name.setText(names[position]);
            holder.introduce.setText(introduces[position]);
            holder.iv.setBackgroundResource(icons[position]);
            return converView;
        }
    }

}
