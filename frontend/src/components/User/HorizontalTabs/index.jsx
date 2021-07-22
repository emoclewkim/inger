import { Tabs, Tab } from '@material-ui/core';
import Wrapper from './styles';
import MyCalendar from '../MyCalendar';

export default function HorizontalTabs() {
    const labels = ['Calendar', 'Todo-list'];
    return (
        <Wrapper>
        <Tabs orientation="horizontal"
            variant="scrollable">
            {labels.map((x, index) => {
                return (
                    <Tab
                        key={index}
                        label={x}
                        style={{
                            fontWeight: 'bold',
                            color: index === 0 ? '#E96F02' : 'white'
                        }}
                    />
                )
            })
            }
        </Tabs>
            <MyCalendar />
        </Wrapper>
    );
};