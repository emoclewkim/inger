import { AppBar, Grid } from "@material-ui/core";

const Header = () => {
  return (
    <>
      <AppBar position='fixed' className='appbar'>
        <Grid container>
          <Grid item>
            My Page
          </Grid>
          <Grid item>
            방 입장
          </Grid>
        </Grid>
      </AppBar>
    </>
  );
};

export default Header;