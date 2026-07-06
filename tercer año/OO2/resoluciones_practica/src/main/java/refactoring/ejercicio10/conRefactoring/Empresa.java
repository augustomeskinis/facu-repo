package refactoring.ejercicio10.conRefactoring;


import java.util.ArrayList;
import java.util.List;

public class Empresa {
    GestorNumerosDisponibles guia = new GestorNumerosDisponibles();
    private List<Cliente> clientes = new ArrayList<Cliente>();


    public Cliente registrarUsuario(String data, String nombre, String tipo) {
        String tel = guia.obtenerNumeroLibre();
        Cliente cliente;
        if (tipo.equals("fisica")) {
            cliente = new ClienteFisico(nombre, tel, data);
        } else { // juridica
            cliente = new ClienteJuridico(nombre, tel, data);
        }
        clientes.add(cliente);
        return cliente;
    }

    public double calcularMontoTotalLlamadas (Cliente cliente){
        return cliente.calcularMontoTotal();
    }

    public boolean agregarNumeroTelefono(String nro) {
        return guia.agregarNumerosDeTelefono(nro);   // delega → mata el feature envy
    }

    public Llamada registrarLlamada(Cliente origen, Cliente destino, LLamadaStrategy strategy, int duracion) {
        return origen.registrarLlamada(destino, strategy, duracion); // delega → Move Method
    }

    public String obtenerNumeroLibre() {
        return guia.obtenerNumeroLibre();
    }

    public int cantidadDeUsuarios() {
        return clientes.size();
    }

    public boolean existeUsuario(Cliente persona) {
        return clientes.contains(persona);
    }

    public GestorNumerosDisponibles getGestorNumeros() {
        return this.guia;
    }

}
