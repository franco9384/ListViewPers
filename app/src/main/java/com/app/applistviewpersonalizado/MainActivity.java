package com.app.applistviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener  {
    EditText etNombre,etPaterno,etMaterno, etMatricula,etTelefono,etCorreo;
    Button btAgregar,btLimpiar;
    ListView lvAlumnos;
    //Se declaran los elementos.
    ArrayList<Item> elementos;
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre=(EditText) findViewById(R.id.etNombre);
        etPaterno=(EditText) findViewById(R.id.etPaterno);
        etMaterno=(EditText) findViewById(R.id.etMaterno);
        etMatricula=(EditText) findViewById(R.id.etMatricula);
        etTelefono=(EditText) findViewById(R.id.etTelefono);
        etCorreo=(EditText) findViewById(R.id.etCorreo);
        btAgregar=(Button) findViewById(R.id.btAgregar);
        btLimpiar=(Button) findViewById(R.id.btLimpiar);
        lvAlumnos=(ListView) findViewById(R.id.lvAlumnos);
        //Se crean los elementos.
        elementos=new ArrayList<Item>();
        adapter =new ItemAdapter(this,elementos);
        lvAlumnos.setAdapter(adapter);
        //Orejas para escuchar los clics en este contexto
        btAgregar.setOnClickListener(this);
        btLimpiar.setOnClickListener(this);
        lvAlumnos.setOnItemClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btAgregar:
                String nombre,paterno,materno,matricula,numero,correo;
                matricula=etMatricula.getText().toString();
                numero=etTelefono.getText().toString();
                nombre=etNombre.getText().toString();
                paterno=etPaterno.getText().toString();
                materno=etMaterno.getText().toString();
                correo=etCorreo.getText().toString();
                //Se agregan los datos que apareceran al agregar.
                Item obj =new Item(matricula, nombre, numero);
                elementos.add(obj);//Se agregan los nuevos obj a elementos
                adapter.notifyDataSetChanged();//Se notifican los cambios
                //Se limpian los cuadros de textos.
                etNombre.setText("");
                etPaterno.setText("");
                etMaterno.setText("");
                etMatricula.setText("");
                etTelefono.setText("");
                etCorreo.setText("");
                etNombre.requestFocus();//Regresa el cursor a etNombre
                break;
            case R.id.btLimpiar:
                elementos.clear();
                adapter.notifyDataSetChanged();
                etNombre.requestFocus();
                break;
        }
    }
    //Se sobreescribe el AdapterView.OnItemClickListener
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      switch (parent.getId()){
          case R.id.lvAlumnos:
              int clave;
              clave= ((Item)parent.getItemAtPosition(position)).getClave();
              break;
      }
    }
}