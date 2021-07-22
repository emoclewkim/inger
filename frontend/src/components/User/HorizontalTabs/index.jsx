import { Tabs, Tab } from '@material-ui/core';

export default function HorizontalTabs() {
    const labels = ['Calendar', 'Todo-list'];
    return (
        <Tabs orientation="horizontal"
            variant="scrollable">
            {labels.map((x, index) => {
                return (
                    <Tab
                        key={index}
                        label={x}
                    />
                )
            })
            }
        </Tabs>
    );
};