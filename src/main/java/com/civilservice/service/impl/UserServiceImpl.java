package com.civilservice.service.impl;

import com.civilservice.dto.User;
import com.civilservice.service.UserService;
import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
        @Autowired
        private RestTemplate restTemplate;

        private static final String ROOT_URI = "https://bpdts-test-app.herokuapp.com/users";
        private static final String LONDON_ROOT_URI = "https://bpdts-test-app.herokuapp.com/city/London/users";

        public List<User> getUsers() {
            ResponseEntity<User[]> usersWithinRadius = restTemplate.getForEntity(ROOT_URI, User[].class);
            List<User> usersWithin50 = parse(Arrays.asList(usersWithinRadius.getBody()));
            ResponseEntity<User[]> usersWithinLondon = restTemplate.getForEntity(LONDON_ROOT_URI, User[].class);
            usersWithin50.addAll(Arrays.asList(usersWithinLondon.getBody()));
            return usersWithin50;
        }

        public List<User> parse(List<User> usersLondon)
        {
            List<User> qualifyingUsers = new ArrayList<>();
            double londonLat = 51 + (30 / 60.0) + (26 / 60.0 / 60.0);
            double londonLon = 0 - (7 / 60.0) - (39 / 60.0 / 60.0);
            if (!CollectionUtils.isEmpty(usersLondon))
            {
                usersLondon.stream().forEach(userInLondon -> {

                    double userLat = Double.valueOf(userInLondon.getLatitude());
                    double userLon = Double.valueOf(userInLondon.getLongitude());

                    GeodesicData result = Geodesic.WGS84.Inverse(londonLat, londonLon, userLat, userLon);

                    double distanceInMeters = result.s12;
                    double distanceInMiles = distanceInMeters / 1609.34;

                    if (distanceInMiles <= 50)
                    {
                        qualifyingUsers.add(userInLondon);
                    }
                });
            }
            return qualifyingUsers;
        }

    }

