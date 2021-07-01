package datastorage;

import model.Caregiver;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CaregiverDAO extends DAOimp<Caregiver>{

    public CaregiverDAO(Connection conn) {
        super(conn);
    }

    protected String getCreateStatementString(Caregiver Caregiver) {
        return String.format("INSERT INTO Caregiver (firstname, surname, Telephone) VALUES ('%s', '%s', '%s')",
                Caregiver.getFirstName(), Caregiver.getSurname(), Caregiver.getTelephone());
    }

    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT * FROM Caregiver WHERE pid = %d", key);
    }

    protected Caregiver getInstanceFromResultSet(ResultSet result) throws SQLException {
        Caregiver p = null;
        p = new Caregiver(result.getInt(1), result.getString(2),
                result.getString(3), result.getString(4));
        return p;
    }

    protected String getReadAllStatementString() {
        return "SELECT * FROM Caregiver ";
    }

    protected ArrayList<Caregiver> getListFromResultSet(ResultSet result) throws SQLException {
        ArrayList<Caregiver> list = new ArrayList<Caregiver>();
        Caregiver p = null;
        while (result.next()) {
            p = new Caregiver(result.getInt(1), result.getString(2),
                    result.getString(3), result.getString(4));
            list.add(p);
        }
        return list;
    }

    protected String getUpdateStatementString(Caregiver Caregiver) {
        return String.format("UPDATE Caregiver SET firstname = '%s', surname = '%s', Telephone = '%s' " +
                "WHERE pid = %d", Caregiver.getFirstName(), Caregiver.getSurname(), Caregiver.getTelephone(), Caregiver.getPid());
    }

    protected String getDeleteStatementString(long key) {
        return String.format("Delete FROM Caregiver WHERE pid=%d", key);
    }
    protected String getLockStatementString(long key) {
        return String.format("Update Caregiver SET \"Lock\"=false WHERE pid=%d", key);
    }

}
