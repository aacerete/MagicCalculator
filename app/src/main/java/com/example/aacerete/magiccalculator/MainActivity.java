package com.example.aacerete.magiccalculator;
import android.view.MotionEvent;
import android.widget.Button;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import me.grantland.widget.AutofitHelper;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView display;

    String modeAction = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFontStyle();
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);
        AutofitHelper.create(display);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initButtons();

    }

    private void initButtons() {
        Button btnZero = (Button) findViewById(R.id.btnZero);
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });
        Button btnOne = (Button) findViewById(R.id.btnOne);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnTwo = (Button) findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnThree = (Button) findViewById(R.id.btnThree);
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnFour = (Button) findViewById(R.id.btnFour);
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnFive = (Button) findViewById(R.id.btnFive);
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnSix = (Button) findViewById(R.id.btnSix);
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnSeven = (Button) findViewById(R.id.btnSeven);
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnEight = (Button) findViewById(R.id.btnEight);
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnNine = (Button) findViewById(R.id.btnNine);
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnDivisor = (Button) findViewById(R.id.btnDivisor);
        btnDivisor.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        return true;
                    case MotionEvent.ACTION_UP:
                        handleButtonMode((Button) v, event.getEventTime(), event.getDownTime());
                        return true;
                }
                return false;
            }
        });
        Button btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });
        Button btnSum = (Button) findViewById(R.id.btnSum);
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnResta = (Button) findViewById(R.id.btnResta);
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });
        btnClear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                    return true;
                    case MotionEvent.ACTION_UP:
                        handleButtonMode((Button) v, event.getEventTime(), event.getDownTime());
                        return true;
                }
                return false;
            }
        });

        Button btnOperator = (Button) findViewById(R.id.btnOperator);
        btnOperator.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        return true;
                    case MotionEvent.ACTION_UP:
                        handleButtonMode((Button) v, event.getEventTime(), event.getDownTime());
                        return true;
                }
                return false;
            }
        });

        Button btnPercentage = (Button) findViewById(R.id.btnPercentage);
        btnPercentage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        return true;
                    case MotionEvent.ACTION_UP:
                        handleButtonMode((Button) v, event.getEventTime(), event.getDownTime());
                        return true;
                }
                return false;
            }
        });

        Button btnComma = (Button) findViewById(R.id.btnComma);
        btnComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

        Button btnEquals = (Button) findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick((Button) v);
            }
        });

    }

    private void handleButtonMode(Button v, long eventTime, long downTime) {
        long diff = eventTime - downTime;
        if(diff > 1000){
            // release enable mode action
            modeAction = v.getText().toString();
        }else{
            // do simple action
            switch(v.getText().toString()){
                case "C":
                    display.setText("");
                    break;

                case "+/-":
                    display.append("-");
                    break;

                case "%":
                    display.append("%");
                    break;
                case "/":
                    display.append("/");
                    break;
            }
        }
    }

    private void handleButtonClick(Button btn){
        String code = btn.getText().toString();

        if(code.equals("=") && !modeAction.isEmpty()){
            System.out.println("HABILITAMOS MODO -> "+modeAction);
            if(modeAction.equals("C")){

            }
            modeAction = null;
            return;
        }

        if(display.getText().equals("0")){
            display.setText(code);
        }else {
            display.append(code);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void initFontStyle() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/SanFranciscoDisplay-Ultralight.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
