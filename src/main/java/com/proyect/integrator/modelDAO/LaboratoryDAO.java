package com.proyect.integrator.modelDAO;

import com.proyect.integrator.config.Conexion;
import com.proyect.integrator.modelDTO.Laboratory;
import com.proyect.integrator.repository.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaboratoryDAO implements Repository<Laboratory> {

    private Connection getConnection() throws SQLException {
        return Conexion.getConnection();
    }

    @Override
    public List<Laboratory> list() {
        List<Laboratory> laboratories = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM laboratory")) {
            while (rs.next()) {
                Laboratory l = createLaboratory(rs);
                laboratories.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laboratories;
    }

    @Override
    public Laboratory byId(int id) {
        return null;
    }

    @Override
    public void save(Laboratory laboratory) {

    }

    @Override
    public void delete(int id) {

    }

    private Laboratory createLaboratory(ResultSet rs) throws SQLException {
        Laboratory l = new Laboratory();
        l.setIdLaboratory(rs.getInt("idLaboratory"));
        l.setNameL(rs.getString("nameL"));

        return l;
    }
}
