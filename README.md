# Ud3_Ejemplo2
_Ejemplo 2 de la Unidad 3._ 

Creamos _Intents_ explícitos y abrimos varias actividades. Los _Intents_ son explícitos ya que queremos que se abran esas actividades en concreto.

Para ello vamos a seguir los siguientes pasos:

## Paso 1: Creación de los layouts
Primero creamos el layout de la Actividad principal en el fichero _activity_main.xml_:

```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@android:color/holo_blue_dark"
        android:padding="16dp"
        android:text="@string/actividad_1"
        android:textColor="@android:color/white"
        android:onClick="abrirActividad1"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@android:color/holo_green_dark"
        android:padding="16dp"
        android:text="@string/actividad_2"
        android:textColor="@android:color/white"
        android:onClick="abrirActividad2"/>

</LinearLayout>
```
En él creamos dos _TextView_ que al pulsarlos abrirán las actividades, para ello hacemos uso del atributo _onClick_.

Después creamos los layouts de las dos actividades. 
Para crearlos creamos dos nuevos _Layout resource files_ dentro de la carpeta _values_:

_actividad1.xml_:

```
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/actividad_1"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```
y _actividad2.xml_:

```
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/actividad_2"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```
## Paso 2: Creación de las actividades
Ahora vamos a crear las actividades, para ello creamos dos clases Java que extiendan de la clase _AppCompatActivity_ y sobreescriban el 
método _onCreate_. En él se cargará el layout de la actividad usando el método _setContentView_ y accediendo a él a través de la
clase _R_.

_Actividad1.java_:
```
public class Actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad1);
    }
}
```
_Actividad2.java_:
```
public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);
    }
}
```
## Paso 3: Creación de los métodos que crean los _Intents_
El siguiente paso es modificar la clase _MainActivity.java_ e incluir los métodos que serán llamados en los atributos _onClick_ de
cada _TextView_ del layout de la actividad principal. Éstos serán los encargados de crear los _Intents_ explícitos.

_MainActivity.java_:
```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Método que crea un Intent explícito para abrir la Actividad 1
     *
     * @param view
     */
    public void abrirActividad1(View view){
        Intent intent = new Intent(MainActivity.this, Actividad1.class);
        startActivity(intent);
    }

    /**
     * Método que crea un Intent explícito para abrir la Actividad 2
     *
     * @param view
     */
    public void abrirActividad2(View view){
        Intent intent = new Intent(MainActivity.this, Actividad2.class);
        startActivity(intent);
    }
}
```
## Paso 4: Inserción de las actividades en el fichero _AndroidManifest.xml_
Por último, tenemos que indicarle al fichero _AndroidManifest.xml_ que las nuevas actividades existen y tienen como actividad
padre a _MainActivity.java_. Para ello añadimos las siguientes líneas:

```
...
       <activity
            android:name=".Actividad1"
            android:label="@string/actividad_1"
            android:parentActivityName=".MainActivity">
        </activity>
        <activity
            android:name=".Actividad2"
            android:label="@string/actividad_2"
            android:parentActivityName=".MainActivity">
        </activity>
   </application>
</manifest>
```
En cada etiqueta _activity_ indicamos el nombre de la actividad, su etiqueta  que aparecerá cómo título al ejecutarla y quién es
la actividad padre, es decir la principal, de tal forma que así podamos volver a ella pulsando sobre la flecha que aparece en pantalla. 
