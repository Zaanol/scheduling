// @ts-ignore
import Inputmask from 'inputmask';
import { InputBaseProps as InputBasePropsMaterial } from '@material-ui/core';

// @ts-ignore
export interface InputBaseProps extends InputBasePropsMaterial {
    label?: string;
    readonly type?: string;
    value?: string;
    disabled?: boolean;
    valid?: boolean;
    invalidMessage?: string;
    required?: boolean;
    readOnly?: boolean;
    mask?: Inputmask .Options;
    placeholder?: string;
    area?: boolean,
    onChange(value: string): void;
}