
package sucursal;
//CODIGO DE LA CUENTA
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
public class Cuenta {

    private Date fecha_de_creacion;
    private String nombre;
    private String numero_de_cuenta;
//    private String DNI = numero_de_cuenta;
    private Float saldo = 0f;
    
    public Cuenta (String nombre,String DNI){
        
        fecha_de_creacion = new Date(Calendar.getInstance().getTimeInMillis());
        this.nombre = nombre;
        this.numero_de_cuenta = DNI;
    }
    
    public Date getDate(){
        return fecha_de_creacion;
    }
    
    public String getFecha(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String fechaTexto = formatter.format(fecha_de_creacion);
        return fechaTexto;
    }
    
    public boolean setFechaDate (Date fecha){
        fecha_de_creacion = fecha ;
        return true;
    }
    
    public boolean setFecha(String fecha) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        Date FCreacion = sdf.parse(fecha);
        fecha_de_creacion = FCreacion;
        return true;
    }
    
    public Float setSaldo (String saldo){
        
        float saldo1 = Float.parseFloat(saldo);
        this.saldo = saldo1;
        return saldo1;
    }
    
    public boolean setNombre(String nombre){
        this.nombre = nombre;
        return true;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNumerodeCuenta(String numeroDeCuenta){
        numero_de_cuenta = numeroDeCuenta;
    }
    
    public String getIDNumero(){
        return numero_de_cuenta;
    }
    
    public Float getSaldo(){
        //System.out.println("Su saldo es de: " + saldo + " €");
        return saldo;
    }
    
    public void DatosCuenta(){
        System.out.println("Cuenta nº: " + numero_de_cuenta+ ".\n"
                + "Titular: "+nombre+".\nDNI: "+numero_de_cuenta+".\nFecha de creación: "+fecha_de_creacion+"\nSaldo: "+saldo+"€");
    }
    
    public boolean ingreso (float cantidad){
        if (cantidad < 0){
           JOptionPane.showMessageDialog(null, "Compruebe cantidad.", "Error.", JOptionPane.ERROR_MESSAGE);
            return false;
            }
        saldo+=cantidad;
        return true;
    }
    
    public boolean reintegro (float cantidad){
        
        if (saldo - cantidad < 0){
            JOptionPane.showMessageDialog(null, "Compruebe fondos.", "Error.", JOptionPane.ERROR_MESSAGE);
           // System.out.println("No dispone de saldo suficiente.");
            return false;
        }
        
        if(cantidad < 0 ){
            JOptionPane.showMessageDialog(null, "Compruebe cantidad.", "Error.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        saldo -= cantidad;
        
        JOptionPane.showInternalMessageDialog(null, "Extracción generada correctamente.",
                "Confirmación.", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public boolean transferencia (Cuenta cuentaDestino , float cantidad){
        
        if(reintegro(cantidad)==true){
            cuentaDestino.ingreso(cantidad);
            JOptionPane.showInternalMessageDialog(null, "Transferencia realizada correctamente.",
                    "Confirmación.", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        
        return false;
    }
}


