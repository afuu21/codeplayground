package com.example.minipro1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class iaInfo extends AppCompatActivity {
    Button parsexmlbutton1;
    Button parsexmlbutton2;
    Button parsexmlbutton3;

    TextView resulttextview;

    EditText eia1,eia2,eia3;
    TextView tia1,tia2,tia3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ia_info);

        parsexmlbutton1=findViewById(R.id.parsexmlbutton1);
        parsexmlbutton2=findViewById(R.id.parsexmlbutton2);
        parsexmlbutton3=findViewById(R.id.parsexmlbutton3);

        eia1 = (EditText)findViewById(R.id.eia1);
        eia2 = (EditText)findViewById(R.id.eia2);
        eia3 = (EditText)findViewById(R.id.eia3);

        tia1 = (TextView)findViewById(R.id.tia1);
        tia2 = (TextView)findViewById(R.id.tia2);
        tia3 = (TextView)findViewById(R.id.tia3);

        resulttextview=findViewById(R.id.resulttextView);








        

        parsexmlbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream inputStream=getAssets().open("ia1.xml"); //pointing to the file
                    //parse xml
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
                    Document document = documentBuilder.parse(inputStream); //inputstream -parsed- document DOM

                    StringBuilder stringBuilder=new StringBuilder(); //userdefined buffer
                    stringBuilder.append("CIE -1");
                    stringBuilder.append("\n..............");

                    NodeList nodeList=document.getElementsByTagName("IA-1"); //search the tag name and find the number of similar tags available

                    for (int i=0; i<nodeList.getLength();i++){
                        Node node= nodeList.item(i);
                        if (node.getNodeType()==Node.ELEMENT_NODE){
                            Element element=(Element) node;
                            stringBuilder.append("\n18CS61 :").append(getValue("SSCD",element)); //getvalue user defined function
                            stringBuilder.append("\n18CS62 :").append(getValue("CG",element));
                            stringBuilder.append("\n18CS63 :").append(getValue("WTA",element));
                            stringBuilder.append("\n18CS64X:").append(getValue("Professional_Elective",element));
                            stringBuilder.append("\n18CS65X:").append(getValue("Open_Elective",element));

                            stringBuilder.append("\n..........");
                        }

                    }
                    resulttextview.setText(stringBuilder.toString());
                    inputStream.close();

                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(iaInfo.this,"error parsing"+e.getMessage(),Toast.LENGTH_LONG).show();
                }


            }
        });

        parsexmlbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream inputStream=getAssets().open("ia2.xml"); //pointing to the file
                    //parse xml
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
                    Document document = documentBuilder.parse(inputStream); //inputstream -parsed- document DOM

                    StringBuilder stringBuilder=new StringBuilder(); //userdefined buffer
                    stringBuilder.append("CIE-2");
                    stringBuilder.append("\n..............");

                    NodeList nodeList=document.getElementsByTagName("IA-2"); //search the tag name and find the number of similar tags available

                    for (int i=0; i<nodeList.getLength();i++){
                        Node node= nodeList.item(i);
                        if (node.getNodeType()==Node.ELEMENT_NODE){
                            Element element=(Element) node;
                            stringBuilder.append("\nSSCD(18CS61): ").append(getValue("SSCD",element)); //getvalue user defined function
                            stringBuilder.append("\nCG(18CS62):").append(getValue("CG",element));
                            stringBuilder.append("\nWTA(18CS63):").append(getValue("WTA",element));
                            stringBuilder.append("\n(18CS64x):").append(getValue("Professional_Elective",element));
                            stringBuilder.append("\n(18CS65x):").append(getValue("Open_Elective",element));

                            stringBuilder.append("\n..........");
                        }

                    }
                    resulttextview.setText(stringBuilder.toString());
                    inputStream.close();

                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(iaInfo.this,"error parsing"+e.getMessage(),Toast.LENGTH_LONG).show();
                }


            }
        });

        parsexmlbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream inputStream=getAssets().open("ia3.xml"); //pointing to the file
                    //parse xml
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
                    Document document = documentBuilder.parse(inputStream); //inputstream -parsed- document DOM

                    StringBuilder stringBuilder=new StringBuilder(); //userdefined buffer
                    stringBuilder.append("CIE-3");
                    stringBuilder.append("\n..............");

                    NodeList nodeList=document.getElementsByTagName("IA-3"); //search the tag name and find the number of similar tags available

                    for (int i=0; i<nodeList.getLength();i++){
                        Node node= nodeList.item(i);
                        if (node.getNodeType()==Node.ELEMENT_NODE){
                            Element element=(Element) node;
                            stringBuilder.append("\nSSCD(18CS61): ").append(getValue("SSCD",element)); //getvalue user defined function
                            stringBuilder.append("\nCG(18CS62):").append(getValue("CG",element));
                            stringBuilder.append("\nWTA(18CS63):").append(getValue("WTA",element));
                            stringBuilder.append("\n(18CS64x):").append(getValue("Professional_Elective",element));
                            stringBuilder.append("\n(18CS65x):").append(getValue("Open_Elective",element));

                            stringBuilder.append("\n..........");
                        }

                    }
                    resulttextview.setText(stringBuilder.toString());
                    inputStream.close();

                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(iaInfo.this,"error parsing"+e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });



       








        //before close bracket
    }

    private String getValue(String tag, Element element) {
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }

    public void average(View V){
        float a1 = Integer.parseInt(eia1.getText().toString());
        float a2 = Integer.parseInt(eia2.getText().toString());
        float a3 = Integer.parseInt(eia3.getText().toString());

        float results = a1+a2+a3;
        results=results/3;

        tia1.setText("Average :"+results);

        if(results>=16){
            tia2.setText("Eligible");
            tia3.setText("");
        }
        else {
            tia3.setText("Not Eligible. Please take Replacement Test");
            tia2.setText("");
        }

    }
}