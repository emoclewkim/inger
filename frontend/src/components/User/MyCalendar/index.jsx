import { TextField, Grid } from '@material-ui/core';

import Wrapper from './styles';

const MyCalendar = () => {
    return (
        <Wrapper>
            <form>
                <Grid container spacing={2}>
                    <Grid item xs={6} sm={4}>
                        <Grid container
                            direction="column"
                            justify="center"
                            alignItems="center"
                            >
                            <Grid item>
                                나의 오늘 다짐
                            </Grid>
                            <Grid item
                                className='textfield-grid'
                            style={{
                                backgroundColor:'#292A33'
                            }}>
                                <TextField
                                    multiline={true}
                                    rows={10}
                                    fullWidth
                                    />
                            </Grid>
                        </Grid>
                    </Grid>
                    <Grid item xs={6} sm={4}>
                    <Grid container
                            direction="column"
                            justify="center"
                            alignItems="center"
                            >
                            <Grid item>
                                나의 오늘 일기
                            </Grid>
                            <Grid item
                                className='textfield-grid'
                            style={{
                                backgroundColor:'#292A33'
                            }}>
                                <TextField
                                    multiline={true}
                                    rows={10}
                                    />
                            </Grid>
                        </Grid>
                    </Grid>
                    <Grid item xs={6} sm={4}>
                    <Grid container
                            direction="column"
                            justify="center"
                            alignItems="center"
                            >
                            <Grid item>
                                나의 오늘 시간
                            </Grid>
                            <Grid item
                                className='textfield-grid'
                            style={{
                                backgroundColor:'#292A33'
                            }}>
                                <TextField
                                    multiline={true}
                                    rows={10}
                                     />
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </form>
        </Wrapper>
    );
};

export default MyCalendar;