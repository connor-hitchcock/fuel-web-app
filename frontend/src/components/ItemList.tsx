import * as React from 'react';
import { styled } from '@mui/material/styles';
import { Box, List, ListItem, ListItemIcon, ListItemText, Grid } from '@mui/material';
import LocalGasStationIcon from '@mui/icons-material/LocalGasStation';
import DirectionsCarIcon from '@mui/icons-material/DirectionsCar';
import SpeedIcon from '@mui/icons-material/Speed';
import PublicIcon from '@mui/icons-material/Public';
import AnalyticsIcon from '@mui/icons-material/Analytics';

export default function ItemList() {
  return (
    <Box sx={{ flexGrow: 1, maxWidth: 752 }}>
      <Grid container spacing={2}>
        <Grid item xs={12} md={6}>
          <List>
            {/* Fuel Eco Urban */}
            <ListItem>
              <ListItemIcon>
                <LocalGasStationIcon />
              </ListItemIcon>
              <ListItemText
                primary="Urban 7.0L/100km"
              />
            </ListItem>
            {/* Fuel Eco Rural */}
            <ListItem>
              <ListItemIcon>
                <LocalGasStationIcon />
              </ListItemIcon>
              <ListItemText
                primary="Rural 10.0L/100km"
              />
            </ListItem>
            {/* License Plate */}
            <ListItem>
              <ListItemIcon>
                <AnalyticsIcon />
              </ListItemIcon>
              <ListItemText
                primary="HGG743"
              />
            </ListItem>
          </List>
        </Grid>
        <Grid item xs={12} md={6}>
          <List>
            {/* Engine Size and Fuel Type */}
            <ListItem>
              <ListItemIcon>
                <DirectionsCarIcon />
              </ListItemIcon>
              <ListItemText
                primary="1.8L Petrol"
              />
            </ListItem>
            {/* Horsepower and Torque */}
            <ListItem>
              <ListItemIcon>
                <SpeedIcon />
              </ListItemIcon>
              <ListItemText
                primary="150hp | 280nm"
              />
            </ListItem>
            {/* Country */}
            <ListItem>
              <ListItemIcon>
                <PublicIcon />
              </ListItemIcon>
              <ListItemText
                primary="New Zealand"
              />
            </ListItem>
          </List>
        </Grid>
      </Grid>
    </Box>
  );
}
