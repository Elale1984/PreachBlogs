package com.gcu.preach.dao;

import com.gcu.preach.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{


    private static final String INSERT_USER_QUERY="INSERT INTO usermodel(userName, userPassword, userFirstName, " +
            "userLastName, userEmail, userPhoneNumber, userAddress1, userAddress2, userCity, userState, " +
            "userZip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_BY_USERNAME_QUERY="UPDATE usermodel SET userName=?, userPassword=?, " +
            "userFirstName=?, userLastName=?, userEmail=?, userPhoneNumber=?, userAddress1=?, userAddress2=?, " +
            "userCity=?, userState=?, userZip=? WHERE userName=?";
    private static final String GET_USER_BY_USERNAME_QUERY="SELECT * FROM usermodel WHERE userName=?";
    private static final String GET_ALL_USERS_QUERY="SELECT * FROM usermodel";
    private static final String DELETE_USER_BY_USERNAME_QUERY="DELETE FROM usermodel WHERE userName=?";


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserModel getUserByUsername(String username) {
        return jdbcTemplate.queryForObject(GET_USER_BY_USERNAME_QUERY,(rs, rowNum) -> new UserModel(rs.getString("userName"),
                rs.getString("userPassword"),
                rs.getString("userFirstName"),
                rs.getString("userLastName"),
                rs.getString("userEmail"),
                rs.getString("userPhoneNumber"),
                rs.getString("userAddress1"),
                rs.getString("userAddress2"),
                rs.getString("userCity"),
                rs.getString("userState"),
                rs.getString("userZip")), username);
    }

    @Override
    public boolean create(UserModel userModel) {
        jdbcTemplate.update(INSERT_USER_QUERY, userModel.getUserName(), userModel.getUserPassword(), userModel.getUserFirstName(),
                userModel.getUserLastName(), userModel.getUserEmail(), userModel.getUserPhoneNumber(), userModel.getUserAddress1(),
                userModel.getUserAddress2(), userModel.getUserCity(), userModel.getUserState(), userModel.getUserZip());
        return true;
    }

    @Override
    public boolean update(UserModel userModel) {
        jdbcTemplate.update(UPDATE_USER_BY_USERNAME_QUERY, userModel.getUserName(), userModel.getUserPassword(),
                userModel.getUserFirstName(), userModel.getUserLastName(), userModel.getUserEmail(), userModel.getUserPhoneNumber(),
                userModel.getUserAddress1(), userModel.getUserAddress2(), userModel.getUserCity(), userModel.getUserState(),
                userModel.getUserZip(), userModel.getUserName());
        return true;
    }

    @Override
    public String delete(UserModel userModel) {
        jdbcTemplate.update(DELETE_USER_BY_USERNAME_QUERY, userModel.getUserName());
        return "User deleted with username " + userModel.getUserName();
    }

    @Override
    public List<UserModel> getAllUsers() {
        return jdbcTemplate.query(GET_ALL_USERS_QUERY, (rs, rowNum) -> new UserModel(rs.getString("userName"),
                rs.getString("userPassword"),
                rs.getString("userFirstName"),
                rs.getString("userLastName"),
                rs.getString("userEmail"),
                rs.getString("userPhoneNumber"),
                rs.getString("userAddress1"),
                rs.getString("userAddress2"),
                rs.getString("userCity"),
                rs.getString("userState"),
                rs.getString("userZip")));
    }


}