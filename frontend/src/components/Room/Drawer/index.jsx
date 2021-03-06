import clsx from 'clsx';
import { useState } from 'react';

import DrawerContainer from '../../../containers/DrawerContainer';

import { Drawer, IconButton, Container } from '@material-ui/core';

import { ChevronRight, AccountBox, Assignment } from '@material-ui/icons';

import { Wrapper } from './styles';

const RoomDrawer = ({
  children,
  handleDrawerClose,
  open,
  classes,
  currentUserData,
}) => {
  const [drawerId, setDrawerId] = useState('drawerProfile');

  const handleDrawerNo = (e) => {
    const drawerId = e.currentTarget.id;
    setDrawerId(drawerId);
  };

  return (
    <Wrapper>
      <Container>
        <main
          className={clsx(classes.content, {
            [classes.contentShift]: open,
          })}
        >
          {children}
        </main>
      </Container>

      <Drawer
        className="drawer"
        variant="persistent"
        anchor="right"
        open={open}
      >
        <div className={classes.drawerHeader}>
          <IconButton onClick={handleDrawerClose}>
            <ChevronRight className="chevron-right" />
          </IconButton>
          <div className="drawerHeader-right-container">
            <IconButton
              id="drawerProfile"
              className="icon-button"
              onClick={handleDrawerNo}
            >
              <AccountBox />
            </IconButton>
            <IconButton
              id="drawerTodo"
              className="icon-button"
              onClick={handleDrawerNo}
            >
              <Assignment />
            </IconButton>
          </div>
        </div>
        <DrawerContainer drawerId={drawerId} currentUserData={currentUserData} />
      </Drawer>
    </Wrapper>
  );
};

export default RoomDrawer;
