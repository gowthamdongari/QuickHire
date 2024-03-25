package com.example.quickhirebackend.dao;

import com.example.quickhirebackend.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;

@Repository
public class ProfessionalDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProfessionalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserProfile demo(UserProfile user){
        String sql = "INSERT INTO userprofile (address, city, email, firstname, lastname, phone, pincode, state, status, username) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1,user.getAddress());
                    ps.setString(2,user.getCity());
                    ps.setString(3,user.getEmail());
                    ps.setString(4,user.getFirstname());
                    ps.setString(5,user.getLastname());
                    ps.setString(6,user.getPhone());
                    ps.setString(7,user.getPincode());
                    ps.setString(8,user.getState());
                    ps.setString(9,user.getStatus());
                    ps.setString(10,user.getUsername());
                    return ps;

                }
         , keyHolder
        );
        if (keyHolder.getKeys().size() > 1) {
            user.setUserprofileid((int) keyHolder.getKeys().get("userprofileid"));
        }else {user.setUserprofileid(keyHolder.getKey().intValue()); }

       String qsql = "INSERT INTO qualifications (type, keywords, profid) VALUES (?, ?, ?)";

        KeyHolder key = new GeneratedKeyHolder();


        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(qsql,Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1,"skills");
                    ps.setString(2,"java");
                    ps.setInt(3,user.getUserprofileid());
                    return  ps;
                }, key
        );
        int quaid=0;

        if(key.getKeys().size()>1){
            quaid = (int) key.getKeys().get("qualificationid");
        }
        else{
            quaid = key.getKey().intValue();
        }

        String profreqsql = "INSERT INTO professionalrequest (major, requesttype, schoolname, profid) VALUES (?, ?, ?,?)";

        KeyHolder kepre = new GeneratedKeyHolder();

        jdbcTemplate.update(
                connection ->{
                    PreparedStatement ps = connection.prepareStatement(profreqsql,Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, "Grad");
                    ps.setString(2, "newaccount");
                    ps.setString(3, "smu");
                    // Convert java.util.Date to java.sql.Timestamp

                    ps.setInt(4, user.getUserprofileid());
                    return ps;
                },
            kepre
        );
        int prefreqid =0;
        if(key.getKeys().size()>1){
            prefreqid = (int) key.getKeys().get("prequestid");
        }
        else{
            prefreqid = key.getKey().intValue();
        }

       return  getUserProfileById(user.getUserprofileid());

    }

    public UserProfile getUserProfileById(int userprofileId) {
        String sql = "SELECT * FROM userprofile WHERE userprofileid = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{userprofileId}, new RowMapper<UserProfile>() {
            @Override
            public UserProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserProfile userProfile = new UserProfile();
                userProfile.setUserprofileid(rs.getInt("userprofileid"));
                userProfile.setAddress(rs.getString("address"));
                userProfile.setCity(rs.getString("city"));
                userProfile.setEmail(rs.getString("email"));
                userProfile.setFirstname(rs.getString("firstname"));
                userProfile.setLastname(rs.getString("lastname"));
                userProfile.setPhone(rs.getString("phone"));
                userProfile.setPincode(rs.getString("pincode"));
                userProfile.setState(rs.getString("state"));
                userProfile.setStatus(rs.getString("status"));
                userProfile.setUsername(rs.getString("username"));
                return userProfile;
            }
        });
    }
    }



