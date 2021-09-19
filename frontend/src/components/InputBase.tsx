import { FC, useEffect, useRef } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { InputBaseProps } from '../types';
// @ts-ignore
import Inputmask from 'inputmask';
import { InputBase as InputBaseMaterial } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  root: {
    padding: '2px 4px',
    display: 'flex',
    alignItems: 'center',
    width: 400,
  },
  input: {
    marginLeft: theme.spacing(1),
    flex: 1,
  },
  iconButton: {
    padding: 10,
  },
  divider: {
    height: 28,
    margin: 4,
  },
}));

export const InputBase: FC<InputBaseProps> = (props) => {
  const { mask, readOnly, disabled, onChange } = props;
  const elementRef = useRef();
  const classes = useStyles();

  useEffect(() => {
      if (mask) {
          new Inputmask({
              autoUnmask: !readOnly,
              showMaskOnHover: false,
              ...mask
          }).mask(elementRef.current);
      }
  }, [readOnly]);

  return <InputBaseMaterial
      ref={elementRef}
      className={classes.input}
      {...props}
      onChange={e => !disabled && onChange((e.target).value)}
  />;
};

InputBase.defaultProps = {
  type: 'text'
}