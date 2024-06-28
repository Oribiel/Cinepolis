package Negocio;

import Negocio.excepcion.NegocioException;
import Negocio.interfaces.IClienteNegocio;
import DTO.ClienteDTO;
import Negocio.convertidores.ClienteCVR;
import Persistencia.ClienteDAO;
import Persistencia.ConexionBD;
import Persistencia.interfaces.IClienteDAO;
import Persistencia.excepcion.PersistenciaException;
import entidad.Cliente;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteNegocio implements IClienteNegocio {

    IClienteDAO clienteDAO = new ClienteDAO(new ConexionBD());
    ClienteCVR clienteCVR;
    
    public ClienteNegocio() {
        this.clienteCVR = new ClienteCVR();
    }

    public ClienteNegocio(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void registrarCliente(ClienteDTO clienteDTO) throws NegocioException {
        try {
            // Validaciones de campos obligatorios
            if (clienteDTO.getNombre() == null || clienteDTO.getNombre().isEmpty()) {
                throw new NegocioException("El nombre es obligatorio.");
            }
            if (clienteDTO.getApellidoPaterno() == null || clienteDTO.getApellidoPaterno().isEmpty()) {
                throw new NegocioException("El apellido paterno es obligatorio.");
            }
            if (clienteDTO.getCorreo() == null || clienteDTO.getCorreo().isEmpty()) {
                throw new NegocioException("El correo electrónico es obligatorio.");
            }
            if (clienteDTO.getFechaNacimiento() == null) {
                throw new NegocioException("La fecha de nacimiento es obligatoria.");
            }
            if (clienteDTO.getContrasena() == null || clienteDTO.getContrasena().isEmpty()) {
                throw new NegocioException("La contraseña es obligatoria.");
            }

            // Validación de formato del correo electrónico
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(clienteDTO.getCorreo());
            if (!matcher.matches()) {
                throw new NegocioException("El formato del correo electrónico no es válido.");
            }

            // Validación de fecha de nacimiento (mayor de 18 años)
            LocalDate fechaNacimiento = clienteDTO.getFechaNacimiento();
            LocalDate ahora = LocalDate.now();
            if (Period.between(fechaNacimiento, ahora).getYears() < 18) {
                throw new NegocioException("El cliente debe ser mayor de 18 años.");
            }

            // Validación de contraseña (mínimo 8 caracteres, al menos una letra y un número)
            String contrasena = clienteDTO.getContrasena();
            if (contrasena.length() < 8 || !contrasena.matches(".*[a-zA-Z].*") || !contrasena.matches(".*\\d.*")) {
                throw new NegocioException("La contraseña debe tener al menos 8 caracteres, incluyendo letras y números.");
            }

            // Asignación de datos al objeto Cliente
            Cliente cliente = new Cliente();
            cliente.setNombre(clienteDTO.getNombre());
            cliente.setApellidoPaterno(clienteDTO.getApellidoPaterno());
            cliente.setApellidoMaterno(clienteDTO.getApellidoMaterno());
            cliente.setCorreo(clienteDTO.getCorreo());
            cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
            cliente.setContrasena(clienteDTO.getContrasena());

            // Registro del cliente
            clienteDAO.crear(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    
    @Override
    public List<ClienteDTO> obtenerClientes() throws NegocioException {
        try {
            return clienteDAO.obtenerClientes();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Cliente buscarPorCorreo(String correo) throws NegocioException {
        try {
            return clienteDAO.buscarPorCorreo(correo);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public void obtenerClientesPaginados(JTable tabla, int numeroPagina, int tamanoPagina) throws NegocioException { 
        try {
            
            List<ClienteDTO> libros = listaPaginada(numeroPagina, tamanoPagina);

            // Definir columnas
            String[] columnNames = {"ID", "Nombre", "ApellidoP", "apellidoM", "Correo"};
            
            // Crear modelo de la tabla
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            // Llenar la tabla con los datos de libros
            for (ClienteDTO cliente : libros) {
                Object[] rowData = {
                    cliente.getIdCliente(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getCorreo(),
                };
                tableModel.addRow(rowData);
            }

            // Establecer el modelo de la tabla
            tabla.setModel(tableModel);
            
        } catch (NegocioException ex) {
            System.out.println(ex.getMessage());;
        }
    }

    private List<ClienteDTO> listaPaginada(int numeroPagina, int tamanoPagina) throws NegocioException{
        try{
            List<ClienteDTO> nuevaLista = new ArrayList<>();
            List<Cliente> entidad = clienteDAO.obtenerClientesPaginados(numeroPagina, tamanoPagina);
            
            for (int i = 0; i < entidad.size(); i++) {
                nuevaLista.add(clienteCVR.entidad_ClienteDTO(entidad.get(i)));
            }
            return nuevaLista;
        }
        catch(PersistenciaException e){
            
        }
        return null;
    }    
}
