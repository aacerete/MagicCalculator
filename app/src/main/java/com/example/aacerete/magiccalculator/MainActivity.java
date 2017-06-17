package com.example.aacerete.magiccalculator;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.InputType;
import android.view.MotionEvent;
import android.widget.Button;

import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.faendir.rhino_android.RhinoAndroidHelper;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.Scriptable;

import me.grantland.widget.AutofitHelper;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView display;
    TextView markbtnC;
    TextView markbtnPercentage;
    TextView markbtnOperator;

    String modeAction = null;
    long modeCronoStart = 0;
    long modeCronoStop = 0;
    String modeAdivina = null;

    private Context context;
    private Scriptable scope;
    private RhinoAndroidHelper rhinoAndroidHelper;
    private boolean modeActionActived;
    private SharedPreferences settings;
    private EditText vibracionCorta;
    private EditText vibracionLarga;
    private EditText intervaloVibracion;
    private EditText intervaloDigito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFontStyle();
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences("Magic", MODE_PRIVATE);
        display = (TextView) findViewById(R.id.display);
        AutofitHelper.create(display);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        markbtnC = (TextView) findViewById(R.id.markbtnC);
        markbtnC.setVisibility(View.INVISIBLE);

        markbtnPercentage = (TextView) findViewById(R.id.markbtnPercentage);
        markbtnPercentage.setVisibility(View.INVISIBLE);

        markbtnOperator = (TextView) findViewById(R.id.markbtnOperator);
        markbtnOperator.setVisibility(View.INVISIBLE);

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

        display.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        return true;
                    case MotionEvent.ACTION_UP:
                        if(modeAction != null && modeAction.equals("%")){
                            if(modeCronoStart == 0){
                                modeCronoStart = event.getEventTime();
                            }else{
                                display.setText(""+(event.getEventTime()-modeCronoStart));
                            }
                        }
                        return true;
                }
                return false;
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
                    if(modeAction != null && modeAction.equals("+/-")){
                        modeAdivina = display.getText().toString();
                        System.out.println("GUARDAMOS ADIVINANZA: "+modeAdivina);
                    }
                    display.setText("0");
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

        if(code.equals("=") && modeAction != null && !modeActionActived){
            System.out.println("HABILITAMOS MODO -> "+modeAction);
            if(modeAction.equals("C")){
                modeActionActived = true;
                markbtnC.setVisibility(View.VISIBLE);
            }
            if(modeAction.equals("%")){
                modeActionActived = true;
                markbtnPercentage.setVisibility(View.VISIBLE);
            }
            if(modeAction.equals("+/-")){
                modeActionActived = true;
                markbtnOperator.setVisibility(View.VISIBLE);
            }
            display.setText("0");
            //modeAction = null;
            return;
        }

        if(code.contains("=")){
            if(modeActionActived){
                if(modeAction.equals("C")) {
                    display.setText(settings.getString("num_guardado", "6666"));
                    markbtnC.setVisibility(View.INVISIBLE);
                }else if(modeAction.equals("+/-")){
                    markbtnOperator.setVisibility(View.INVISIBLE);
                    Vibrator v = (Vibrator) getSystemService(android.content.Context.VIBRATOR_SERVICE);
                    if(modeAdivina != null) {
                        for (int i = 0; i < modeAdivina.length(); i++) {
                            char charact = modeAdivina.charAt(i);
                            if (charact != '.') {
                                Integer num = Integer.parseInt("" + charact);
                                try {
                                    if (num >= 5) {
                                        while (num > 0) {
                                            if (num >= 5) {
                                                v.vibrate(Long.parseLong(settings.getString("vibracion_larga", "500")));
                                                num = num - 5;
                                            } else {
                                                v.vibrate(Long.parseLong(settings.getString("vibracion_corta", "100")));
                                                num = num - 1;
                                            }
                                            Thread.sleep(Long.parseLong(settings.getString("intervalo_vibracion", "500")));
                                        }
                                    } else if (num == 0) {
                                        v.vibrate(Long.parseLong(settings.getString("vibracion_corta", "100")));
                                        Thread.sleep(Long.parseLong(settings.getString("intervalo_vibracion", "500")));
                                        v.vibrate(Long.parseLong(settings.getString("vibracion_corta", "100")));
                                    } else {
                                        for (int j = 0; j < num; j++) {
                                            v.vibrate(Long.parseLong(settings.getString("vibracion_corta", "100")));
                                            Thread.sleep(Long.parseLong(settings.getString("intervalo_vibracion", "500")));
                                        }
                                    }
                                    Thread.sleep(Long.parseLong(settings.getString("intervalo_digito", "2000")));
                                } catch (InterruptedException e) {
                                    e.getLocalizedMessage();
                                }
                            }
                        }
                    }
                }else{
                    display.setText("0");
                }
                modeAction = null;
                modeActionActived = false;
            }else {
                rhinoAndroidHelper = new RhinoAndroidHelper(this);
                context = rhinoAndroidHelper.enterContext();
                context.setOptimizationLevel(-1);
                scope = new ImporterTopLevel(context);
                try {
                    Object result = context.evaluateString(scope, display.getText().toString().replaceAll("X", "*"), "JavaScript", 1, null);
                    display.setText(Context.toString(result));
                } catch (Throwable t) {
                    t.printStackTrace();
                } finally {
                    context.exit();
                }
            }
            return ;
        }

        if(display.getText().toString().equals("0")){
            display.setText(code);
        }else {
            display.append(code);
        }
    }

    @Override
    protected void attachBaseContext(android.content.Context newBase) {
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

        if (id == R.id.nav_num) {
            new MaterialDialog.Builder(this)
                    .title("Número guardado")
                    .content("Introduce el número a forzar")
                    .inputType(InputType.TYPE_CLASS_TEXT)
                    .input("0", settings.getString("num_guardado", "6666"), new MaterialDialog.InputCallback() {
                        @Override
                        public void onInput(MaterialDialog dialog, CharSequence input) {
                            SharedPreferences.Editor editor = settings.edit();
                            editor.putString("num_guardado", input.toString());
                            editor.commit();
                        }
                    }).show();
            // Handle the camera action
        } else if (id == R.id.nav_adivina) {
            MaterialDialog dialog = new MaterialDialog.Builder(this)
                    .title("Configuración Adivinanza")
                    .customView(R.layout.adivinanza_custom, true)
                    .positiveText("Guardar")
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            guardarAdivanzaSettings(vibracionCorta.getText().toString(), vibracionLarga.getText().toString(), intervaloVibracion.getText().toString(), intervaloDigito.getText().toString());
                        }
                    })
                    .build();
            vibracionCorta = (EditText) dialog.getCustomView().findViewById(R.id.vibracion_corta);
            vibracionCorta.setText(settings.getString("vibracion_corta", "100"));
            vibracionLarga = (EditText) dialog.getCustomView().findViewById(R.id.vibracion_larga);
            vibracionLarga.setText(settings.getString("vibracion_larga", "500"));
            intervaloVibracion = (EditText) dialog.getCustomView().findViewById(R.id.intervalo_vibracion);
            intervaloVibracion.setText(settings.getString("intervalo_vibracion", "500"));
            intervaloDigito = (EditText) dialog.getCustomView().findViewById(R.id.intervalo_digito);
            intervaloDigito.setText(settings.getString("intervalo_digito", "2000"));

            dialog.show();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void guardarAdivanzaSettings(String corta, String larga, String vibracion, String digito){
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("vibracion_corta", corta);
        editor.putString("vibracion_larga", larga);
        editor.putString("intervalo_vibracion", vibracion);
        editor.putString("intervalo_digito", digito);
        editor.commit();
    }

}
